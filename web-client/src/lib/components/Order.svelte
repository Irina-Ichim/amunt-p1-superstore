<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

<script>
    import OrderStatusBadge from "./OrderStatusBadge.svelte";
    import {onMount} from "svelte";
    import Modal from "./Modal.svelte";

    export let id;
    export let address;
    export let city;
    export let country;
    export let products = [];

    export let orderStatus;

    export let onCancel;

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
                <p>Envío: {address} - {city} ({country})</p>
                <p>Pedido: {id.slice(0, 6)}</p>
            <OrderStatusBadge {orderStatus} />
            <button on:click={() => onCancel(id)}><span class="material-symbols-outlined">cancel</span></button>
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
                    <td colspan="3">Total</td>
                    <td>{productsData.map( p => p.price).reduce((s, p) => s + p, 0)}€</td>
                </tr>
                </tbody>
            </table>
            </div>
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
        height: 80px;
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        align-items: center;
        background: #e3e6e6;
    }

    .material-symbols-outlined{
        font-size: 28px;
        font-weight: revert;
        cursor: pointer;
        color: red;
    }
</style>