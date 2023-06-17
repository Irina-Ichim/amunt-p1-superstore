<script>
    import {cart, cartSize, cartTotalCost} from "../../store/cart.js";
    import Button from "../components/Button.svelte";
    import {navigate} from "svelte-routing";

    const goToCheckout = () => navigate("/login", {state: {redirectTo: "/checkout"}});
    const continueShopping = () => navigate("/");

    const payButtonEnabled = $cartSize > 0
</script>

<div>
    <table>
        <thead>
        <tr>
            <th>Producto</th>
            <th>Cantidad</th>
            <th>Precio</th>
        </tr>
        </thead>
        <tbody>
        {#each $cart as {name, price}}
            <tr>
                <td>{name}</td>
                <td>1</td>
                <td>{price}€</td>
            </tr>
        {/each}
        <tr>
            <td colspan="3">
                <hr>
            </td>
        </tr>
        <tr>
            <td>Total</td>
            <td>{$cartSize}</td>
            <td>{$cartTotalCost}€</td>
        </tr>
        </tbody>
    </table>
    <ul>
        {#if payButtonEnabled}
            <Button on:click={goToCheckout} orange>Pagar</Button>
        {/if}
        <Button on:click={continueShopping}>Seguir comprando</Button>
    </ul>
</div>

<style>
    div {
        max-width: 500px;
        margin: 50px auto;
    }

    table {
        margin: 50px;
    }

    ul {
        display: flex;
        gap: 30px;
    }

    table {
        text-align: right;
    }

    thead {
        font-weight: bold;
    }

    th {
        min-width: 100px;
    }
</style>