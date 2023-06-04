<script>
    import Logo from "./Logo.svelte";
    import {links, useLocation} from "svelte-routing"
    import {loggedIn} from "../../store/session.js";
    import {cartSize} from "../../store/cart.js";
    import Message from "./Message.svelte";
    const location = useLocation();
    $: message = $location.state && $location.state.message
</script>

<header use:links>
    <a href="/">
        <Logo/>
    </a>
    <nav>
        <a href="/">Ofertas</a>
        <a href="/">Catálogo</a>
        {#if !$loggedIn}
            <a href="/login">Login</a>
        {:else}
            <a href="/my-account">Mi cuenta</a>
        {/if}
        <a href="/cart">Carrito({$cartSize})</a>
    </nav>
</header>
{#if message}
    <Message>{message}</Message>
{/if}

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
