
<script>

    import {Link} from "svelte-routing";


</script>
<div>


        <button><Link to="/new">New Product</Link></button>
       <h1> <Link to="/">products</Link></h1>


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
        align-items: center;
        list-style: none;

    }

    button{

        width: 100px;
        height: 50px;
        margin-left: 100px;
        border-radius: 10px;
        font-size: 15px;
        margin-right: 100px;
        background: red;
        color:white;

    }




</style>