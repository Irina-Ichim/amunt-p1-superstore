<script>
    import {navigate} from "svelte-routing";
    import {loggedIn} from "../store/session.js";
    import {AuthApi} from "../api/AuthApi.js";

    let username;
    let password;
    let loginError;

    let api = new AuthApi();
    let onSubmit = () => {
        api.login(username, password)
            .then(() => {
                navigate("/");
            })
    };
</script>

<form on:submit|preventDefault={onSubmit}>
    <label for="username">User</label>
    <input bind:value={username} type="text" id="username">
    <label for="password">Password</label>
    <input bind:value={password} type="password" id="password">
    <input type="submit" value="Login">
    {#if loginError}
        <span>Usuario Incorrecto</span>
    {/if}
</form>

<style>
    form {
        max-width: 500px;
        margin: 40px auto;
        display: flex;
        flex-direction: column;
    }

    input {
        max-width: 400px;
        height: 30px;
        margin-bottom: 20px;
    }

    input[type="submit"] {
        max-width: 200px;
        height: 30px;
    }

    span {
        background-color: lightcoral;
        color: red;
        padding: 10px;
    }

</style>