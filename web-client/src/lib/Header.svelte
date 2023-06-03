<script>
import Logo from "./Logo.svelte";
</script>

<header>
    <a href="/"><Logo /></a>
    <nav>
        <span>Ofertas</span>
        <span>Catálogo</span>
        <span>Carrito</span>
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

    span {
        padding: 0 10px;
        cursor: pointer;
    }

    span:hover {
        font-weight: bold;
    }

</style>
