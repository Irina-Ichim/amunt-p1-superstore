
<script>

    import {Link} from "svelte-routing";


</script>
<div>


    <button><Link to="/new">Añadir Productos</Link> </button>
    <Link to="/">Productos</Link>

</div>


<style>

    h1 {
        color: white;
    }

    div {
        height: 50px;
        display: flex;
        justify-content: end;
        background-color: darkgrey;
        padding: 35px;
    }

    button{


        width: 280px;
        height: 60px;
        margin-left: 100px;
        border-radius: 10px;
        font-size: larger;
        color: white;
        background-color: skyblue;
        margin-right: 80px;
    }


</style>