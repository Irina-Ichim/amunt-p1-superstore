<script>
    import {products} from "../store/products.js";
    import Button from "./Button.svelte";
    import {navigate} from "svelte-routing";

    export let id;
    let productInfo;

    products.subscribe(value => {
        productInfo = value.find(product => product.id == id)
    })

    let goBack = () => navigate("/");
</script>

<article>
    <img src={productInfo.imageUrl} alt="product image">
    <section>
        <h1>{productInfo.name}</h1>
        <h2>{productInfo.price}€</h2>
        <p>{productInfo.description}</p>
        <Button orange>Añadir a la cesta</Button>
        <Button on:click={goBack}>Volver al catálogo</Button>

    </section>
</article>

<style>
    article {
        padding: 5px;
        width: 100%;
        height: 80vh;
        display: flex;
    }

    img {
        width: 40%;
        object-fit: cover;
    }

    section {
        padding: 70px;
    }
</style>