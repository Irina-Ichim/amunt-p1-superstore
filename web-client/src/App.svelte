<script>
    import {Router, Route} from "svelte-routing";
    import Header from "./lib/Header.svelte";
    import Footer from "./lib/Footer.svelte";
    import Catalog from "./lib/Catalog.svelte";
    import LoginPage from "./lib/LoginPage.svelte";
    import {ProductApi} from "./api/ProductApi.js";
    import {onMount} from "svelte";
    import {products} from "./store/products.js";

    let url = "/";
    let api = new ProductApi();

    onMount(() => {
        api.getAllProducts()
            .then(data => products.set(data))
            .catch( errorMsg => console.log(`Something wrong ${errorMsg}`))
    });
</script>

<Router {url}>
    <Header/>
    <Route path="/login" component={LoginPage}/>
    <Route path="/"  component={Catalog}/>
    <Footer/>
</Router>
