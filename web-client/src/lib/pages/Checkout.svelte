<script>
    import OrderApi from "../../api/OrderApi.js";
    import {navigate} from "svelte-routing";

    let firstName;
    let lastName;
    let nif;
    let address;
    let postalCode;

    let handleSubmit = () => {
        const api = new OrderApi();
        api.createOrder({firstName,lastName,nif,address,postalCode})
            .then(({id}) => navigate("/", {state: {message: `Pedido #${id} realizado con éxito`}}))
    };

</script>

<h1>Completa los detalles de tu pedido</h1>

<form on:submit|preventDefault={handleSubmit}>
    <label for="firstName"> Nombre</label>
    <input type="text" id="firstName" bind:value={firstName}>
    <label for="lastName"> Apellidos</label>
    <input type="text" id="lastName" bind:value={lastName}>
    <label for="nif"> NIF</label>
    <input type="text" id="nif" bind:value={nif}>
    <label for="address"> Dirección</label>
    <input type="text" id="address" bind:value={address}>
    <label for="postalCode"> Código Postal</label>
    <input type="text" id="postalCode" bind:value={postalCode}>
    <input type="submit" value="Confirmar"/>
</form>

<style>
    form {
        max-width: 500px;
        margin: 0 auto;
        display: flex;
        flex-direction: column;
    }
    input {
        width: 70%;
        height: 30px;
        margin-bottom: 15px;

    }
    input[type=submit] {
        width: 30%;
    }
</style>