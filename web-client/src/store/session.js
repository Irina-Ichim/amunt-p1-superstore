import {writable} from "svelte/store";

export let loggedIn = writable(false);
export let currentUser = writable({});