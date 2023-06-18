<script>
    import OrderStatusBadge from "./OrderStatusBadge.svelte";

    export let id;
    export let address;
    export let city;
    export let country;
    export let products = [];

</script>

<article>
    <section>
        <h4>Pedido {id.slice(0,6)} <OrderStatusBadge></OrderStatusBadge></h4>
        <p>Envío: {address} - {city} ({country})</p>
        <p>{products.length} productos</p>
    </section>
</article>

<style>
    article {
        border-top: 1px solid black;
    }
</style>