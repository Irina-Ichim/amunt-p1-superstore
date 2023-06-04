<script>
    import Logo from "./Logo.svelte";
    import {links} from "svelte-routing"
    import {loggedIn} from "../store/session.js";
    import {cart, cartSize} from "../store/cart.js";

    let showLoginButton;
    let cartSizeNumber = 0;

    cartSize.subscribe(value => {
        cartSizeNumber = value;
    })

    loggedIn.subscribe((value) => {
        showLoginButton = !value;
    })
</script>

<header use:links>
    <a href="/">
        <Logo/>
    </a>
    <nav>
        <a href="/">Ofertas</a>
        <a href="/">Catálogo</a>
        {#if showLoginButton}
            <a href="/login">Login</a>
        {:else}
            <a href="/">Mi cuenta</a>
        {/if}
        <a href="/cart">Carrito({cartSizeNumber})</a>
    </nav>
</header>

<style>

    header {
        background-color: aliceblue;
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: 20px;
    }

    a {
        text-decoration: none;
        padding: 0 10px;
        cursor: pointer;
        color: black;
    }

    a:hover {
        font-weight: bold;
    }
</style>
