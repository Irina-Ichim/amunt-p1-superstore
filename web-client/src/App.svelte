<script>
    import {Router, Route} from "svelte-routing";
    import Header from "./lib/Header.svelte";
    import Footer from "./lib/Footer.svelte";
    import Catalog from "./lib/Catalog.svelte";
    import LoginPage from "./lib/LoginPage.svelte";

    let url = "/";
</script>

<Router {url}>
    <Header/>
    <Route path="/login" component={LoginPage}/>
    <Route path="/"  component={Catalog}/>
    <Footer/>
</Router>
