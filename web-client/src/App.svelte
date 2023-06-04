<script>
    import {Route, Router} from "svelte-routing";
    import Header from "./lib/Header.svelte";
    import Footer from "./lib/Footer.svelte";
    import Catalog from "./lib/Catalog.svelte";
    import LoginPage from "./lib/LoginPage.svelte";
    import {ProductApi} from "./api/ProductApi.js";
    import {onMount} from "svelte";
    import {products} from "./store/products.js";
    import ProductPage from "./lib/ProductPage.svelte";
    import Cart from "./lib/Cart.svelte";

    let url = "/";
    let api = new ProductApi();

    onMount(() => {
        api.getAllProducts()
            .then(data => products.update(_ => data))
            .catch(errorMsg => console.log(`Something wrong ${errorMsg}`))
    });
</script>

<Router {url}>
    <Header/>
    <Route path="/login" component={LoginPage}/>
    <Route path="/" component={Catalog}/>
    <Route path="/products/:id" let:params>
        <ProductPage id={params.id}/>
    </Route>
    <Route path="/cart">
        <Cart/>
    </Route>
    <Footer/>
</Router>
