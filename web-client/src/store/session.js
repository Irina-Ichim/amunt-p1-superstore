import {derived, writable} from "svelte/store";

export let loggedIn = writable(false);
export let currentUser = writable({});

export let currentUserName = derived(currentUser, $currentUser => $currentUser.name)
export let currentUserId = derived(currentUser, $currentUser => $currentUser.id)