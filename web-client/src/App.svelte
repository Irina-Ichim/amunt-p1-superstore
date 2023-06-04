<script>
    import {Route, Router} from "svelte-routing";
    import Header from "./lib/components/Header.svelte";
    import Footer from "./lib/components/Footer.svelte";
    import Catalog from "./lib/pages/Catalog.svelte";
    import LoginPage from "./lib/pages/Login.svelte";
    import {ProductApi} from "./api/ProductApi.js";
    import {onMount} from "svelte";
    import {products} from "./store/products.js";
    import ProductPage from "./lib/pages/Product.svelte";
    import Cart from "./lib/pages/Cart.svelte";
    import Checkout from "./lib/pages/Checkout.svelte";
    import MyAccount from "./lib/pages/MyAccount.svelte";

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
    <Route path="/checkout" component={Checkout}/>
    <Route path="/my-account" component={MyAccount}/>
    <Footer/>
</Router>
