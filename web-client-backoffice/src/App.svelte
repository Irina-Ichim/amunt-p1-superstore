<script>

    import ListCard from "./lib/components/ListCard.svelte";
    import {onMount} from "svelte";
    import Product from "./lib/components/Product.svelte";
    import Header from "./lib/components/Header.svelte";

    let productos = [];

    onMount(() => {
        fetch("http://localhost:8080/api/products")
            .then(response => response.json())
            .then(datos => productos = datos)
    })

</script>

<main>
    <Header/>
    <div>
        {#each productos as producto}
            <Product info={producto}/>
        {/each}
    </div>
</main>

<style>
    div {
        margin: 40px 80px;
    }
</style>

