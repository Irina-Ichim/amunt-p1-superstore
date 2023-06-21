<script>
    import {products} from "../../store/products.js";
    import Button from "../components/Button.svelte";
    import {navigate} from "svelte-routing";
    import {cart} from "../../store/cart.js";

    export let id;
    let productInfo;

    products.subscribe(value => {
        productInfo = value.find(product => product.id == id)
    })

    let goBack = () => navigate("/");
    let addProductToCart = () => {
        $cart = [...$cart, productInfo];
        navigate("/", {state: {message: `Añadido ${productInfo.name} a tu carrito`}})
    };
</script>

<article>
    <img src={productInfo.imageUrl} alt={productInfo.description}>
    <section>
        <h1>{productInfo.name}</h1>
        <h2>{productInfo.price}€</h2>
        <p>{productInfo.description}</p>
        <Button on:click={addProductToCart} orange>Añadir a la cesta</Button>
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