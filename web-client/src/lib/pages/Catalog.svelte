<script>
    import ProductCard from "../components/ProductCard.svelte";
    import {products} from "../../store/products.js";

    let productList = [];
    products.subscribe(value => productList = value);

</script>

<section>
    {#each productList as data}
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