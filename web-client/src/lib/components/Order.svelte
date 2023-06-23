<script>


    import OrderStatusBadge from "./OrderStatusBadge.svelte";
    import {onMount} from "svelte";

    export let id;
    export let address;
    export let city;
    export let country;
    export let products = [];

    let productsData = []

    onMount(() => {
        Promise.all(
            products.map(id =>
                fetch(`/api/products/${id}`)
                    .then(response => response.json()))
        ).then(x => {
            productsData = x;
        })
            .then(_ => console.log(productsData))
    })

</script>

<article>
    <section>
        <h4>Pedido {id.slice(0, 6)}
            <OrderStatusBadge></OrderStatusBadge>
        </h4>
        <p>Envío: {address} - {city} ({country})</p>
        {#each productsData as p}
            <p>Producto:{p.name}</p>
            <p>Precio:{p.price}€</p>
        {/each}
    </section>
</article>

<style>
    article {
        border-top: 1px solid black;
    }
</style>