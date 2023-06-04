<script>
    import Logo from "./Logo.svelte";
    import {links} from "svelte-routing"
    import {loggedIn} from "../../store/session.js";
    import {cartSize} from "../../store/cart.js";
</script>

<header use:links>
    <a href="/web-client/public">
        <Logo/>
    </a>
    <nav>
        <a href="/web-client/public">Ofertas</a>
        <a href="/web-client/public">Catálogo</a>
        {#if !$loggedIn}
            <a href="/login">Login</a>
        {:else}
            <a href="/web-client/public">Mi cuenta</a>
        {/if}
        <a href="/cart">Carrito({$cartSize})</a>
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
