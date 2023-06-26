<script>
    import Logo from "./Logo.svelte";
    import {links, useLocation} from "svelte-routing"
    import {loggedIn} from "../../store/session.js";
    import {cartSize} from "../../store/cart.js";
    import Message from "./Message.svelte";
    import {products} from "../../store/products.js";

    const location = useLocation();
    $: message = $location.state && $location.state.message
    let searchQuery = '';

    async function handleSearch(event) {
        if (event.key === 'Enter' && searchQuery !== '') {
            const response = await fetch('/api/products?search=' + searchQuery);
            if (response.ok) {
                let productosEncontrados = await response.json();
                products.update(_ => productosEncontrados);
            } else {
                console.error('Error:', response.status);
            }
        }
    }
</script>

<header use:links>
    <a href="/">
        <Logo/>
    </a>
    <div class="search-input">
        <svg xmlns="http://www.w3.org/2000/svg"
             viewBox="0 0 50 50"
             width="20px" height="20px">
            <path d="M 21 3 C 11.621094 3 4 10.621094 4 20 C 4 29.378906 11.621094 37 21 37 C 24.710938 37 28.140625 35.804688 30.9375 33.78125 L 44.09375 46.90625 L 46.90625 44.09375 L 33.90625 31.0625 C 36.460938 28.085938 38 24.222656 38 20 C 38 10.621094 30.378906 3 21 3 Z M 21 5 C 29.296875 5 36 11.703125 36 20 C 36 28.296875 29.296875 35 21 35 C 12.703125 35 6 28.296875 6 20 C 6 11.703125 12.703125 5 21 5 Z"/>
        </svg>

        <input
                type="text"
                bind:value={searchQuery}
                placeholder="Buscar Productos"
                on:keyup={handleSearch}
        />
    </div>

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
    .search-input {
        position: relative;
        display: flex;
        align-items: center;
        border: 2px solid white;
        padding: 13px;
        font-size: 20px;
        background-color: white;
        border-radius: 10px;
        width: 173px;
        left: 245px;
    }

    .search-input svg {
        position: absolute;
        left: 8px;
        fill: #000;
        cursor: pointer;
    }

    .search-input input {

        position: relative;
        border: none;
        outline: none;
        left: 14px;
    }

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
