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
        <div class="pedido-envio">
        <h4>Pedido {id.slice(0, 6)}
            <OrderStatusBadge></OrderStatusBadge>
        </h4>
        <p>Envío: {address} - {city} ({country})</p>
        </div>
        <div>
            <table>
                <thead>
                <tr>
                    <th>Producto</th>
                    <th>Descripción</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                </tr>
                </thead>
                <tbody>
                {#each productsData as p}
                    <tr>
                        <td><img src={p.imageUrl} alt="product image"/></td>
                        <td>{p.name}</td>
                        <td>1</td>
                        <td>{p.price}€</td>
                    </tr>
                {/each}
                <tr>
                    <td colspan="4">
                        <hr>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">Total</td>
                    <td>Cart Size</td>
                    <td> Total cost €</td>
                </tr>
                </tbody>
            </table>
    </section>
</article>

<style>

    table {
        width: 900px;
        margin-top: 40px;
    }

    thead {
        font-weight: bold;
    }

    th {
        text-align: left;
        font-weight: bold;
    }

    img{
        width: 120px;
    }

    .pedido-envio{
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        background: #e3e6e6;
    }


</style>