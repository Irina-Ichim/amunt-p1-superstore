<script>
    import {ProductApi} from "../api/ProductApi.js";
    import {onMount} from "svelte";
    import ProductCard from "./ProductCard.svelte";

    let products = [];
    let api = new ProductApi();

    onMount(() => {
        api.getAllProducts()
            .then(data => products = data)
            .catch( errorMsg => console.log(`Something wrong ${errorMsg}`))
    });
</script>

<section>
    {#each products as data}
        <ProductCard {...data}/>
    {/each}
</section>

<style>
    section {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        padding: 50px;
        gap: 50px;
        background-color: #e3e6e6;
    }
</style>