<script>

    import {Link} from "svelte-routing";

    import {dev} from "../../dev.js";

    let path = dev ? "" : "/admin"

</script>
<div>


    <Link style={"color: white; text-decoration: none;"} to={path+"/new"}>New Product</Link>
    <Link style={"color: white; text-decoration: none"} to={path+"/"}>products</Link>


</div>


<style>

    div {
        height: 50px;
        display: flex;
        justify-content: end;
        background-color: darkgrey;
        padding: 35px;
        gap: 20px;
        align-items: center;

    }


</style>