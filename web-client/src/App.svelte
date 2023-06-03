<script>
    import {onMount} from "svelte";
    import SongsApi from "./api/songsApi.js";
    import logo from "./assets/logo."

    let songs = [];
    let api = new SongsApi();
    let errorMsg;

    onMount(() => {
        api.getSongs()
            .then(data => songs = data)
            .catch(error => errorMsg = error)
    });
</script>

<header>
    <img src={logo}/>
</header>