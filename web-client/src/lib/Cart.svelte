<script>
    import {cart, cartSize, cartTotalCost} from "../store/cart.js";
    import Button from "./Button.svelte";
    import {navigate} from "svelte-routing";
</script>

<table>
    <thead>
    <tr>
        <td>Producto</td>
        <td>Cantidad</td>
        <td>Precio</td>
    </tr>
    </thead>
    <tbody>
    {#each $cart as {name, price}}
        <tr>
            <td>{name}</td>
            <td>1</td>
            <td>{price}</td>
        </tr>
    {/each}
    <hr>
    <tr>
        <td>Total</td>
        <td>{$cartSize}</td>
        <td>{$cartTotalCost}</td>
    </tr>
    </tbody>
</table>
<Button orange on:click={() =>  navigate("/login", {state: {redirectTo: "/checkout"}})}>Pagar</Button>
<Button on:click={() =>  navigate("/")}>Seguir comprando
</Button>