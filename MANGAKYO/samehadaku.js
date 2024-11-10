// Pencarian Komik
document.getElementById("searchButton").addEventListener("click", () => {
    const searchText = document.getElementById("searchInput").value.toLowerCase();
    const comics = document.querySelectorAll(".comic");

    comics.forEach(comic => {
        const title = comic.querySelector("p").textContent.toLowerCase();
        if (title.includes(searchText)) {
            comic.style.display = "block";
        } else {
            comic.style.display = "none";
        }
    });
});
