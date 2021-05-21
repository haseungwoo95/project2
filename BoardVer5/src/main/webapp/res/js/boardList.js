function searchToList() {
	var search = document.getElementById("search").value;
	location.href = 'list?search=' + search + '&chksearch=' + 1;
}

function moveToDetail(iboard) {
	location.href = 'detail?iboard=' + iboard;
}

