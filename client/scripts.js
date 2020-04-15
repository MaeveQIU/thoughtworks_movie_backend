const getData = () => {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", `http://127.0.0.1:8080/movies/basic/all`, false);
  xhr.send();
  if (xhr.readyState === 4 && xhr.status === 200) {
    return JSON.parse(xhr.responseText);
  }
}

const getDataByPage = page => {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", `http://127.0.0.1:8080/movies/basic/page?page=${page}&number=48`, false);
  xhr.send();
  if (xhr.readyState === 4 && xhr.status === 200) {
    return JSON.parse(xhr.responseText);
  }
}

const allMovieList = getData();
const movieList = allMovieList.slice(0, 48);

const getGenre = movieList => {
  let newList = [];
  movieList.forEach(element => {
    element.genres.split(",").forEach(item => {
      if (!newList.includes(item)) {
        newList.push(item);
      }
    });
  });
  return newList;
}

const renderGenre = genreList => {
  genreList.forEach(element => {
    const newGenre = document.createElement("li");
    newGenre.setAttribute("id", `${element}`);
    newGenre.setAttribute("class", `genre-list`);
    newGenre.innerHTML = `${element}`;
    document.getElementById("genre-list").appendChild(newGenre);
  })
}

const renderMovie = movieList => {
  movieList.forEach(element => {
    const newMovie = document.createElement("div");
    newMovie.innerHTML = `
    <img src=${element.image}>
    <p class="title">${element.title}</p>
    <p class="rating">Rating: ${element.rating}</p>`
    document.getElementById("movies").appendChild(newMovie)
  });
}

const clearList = node => {
  document.getElementById(node).innerHTML = "";
}

const filterList = genre => {
  return allMovieList.filter(element => element.genres.includes(genre));
}

const getInput = () => {
  const input = window.location.href.split("?")[1];
  const value = input.split("=")[1];
  return value;
}

const getDecodeInput = () => {
  const input = decodeURIComponent(window.location.href.split("?")[1]);
  const value = input.split("=")[1];
  return value;
}

const getSearchResult = input => {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", `http://127.0.0.1:8080/movies/result/${input}`, false);
  xhr.send();
  if (xhr.readyState === 4 && xhr.status === 200) {
    return JSON.parse(xhr.responseText);
  }
}

const displayResult = resultArr => {
  if (resultArr != null) {
    resultArr.forEach(element => {
      const result = document.createElement("div");
      result.setAttribute("class", "movie-result")
      result.innerHTML = `
      <img src=${element.image}>
      <p class="title">${element.title}</p>
      <p>Rating: ${element.rating}</p>
      <p>Year: ${element.year}</p>
      <p>Directors: ${element.directors}</p>
      <p>Casts: ${element.casts.split(",").join(", ")}</p>
      <p>Duration: ${element.duration}`
      document.getElementById("main").appendChild(result);
    });
  }
  else {
    const line = document.createElement("div");
    line.setAttribute("class", "no-result")
    line.innerHTML = `
    <p>Sorry we can't find the movie you're searching for.<br>
    But we're constantly updating our database.<br>
    So stay tuned! ❤︎</p>`
    document.getElementById("main").appendChild(line);
  }
}

const getReviews = id => {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", `http://127.0.0.1:8080/movies/review/${id}`, false);
  xhr.send();
  if (xhr.readyState === 4 && xhr.status === 200) {
    return JSON.parse(xhr.responseText);
  }
}

const calculateScoreAndRank = movieItem => {
  const movieDatabase = allMovieList;
  movieDatabase.forEach(element => {
    let score = 0;
    score += (movieItem.year === element.year) ? 1 : 0;
    score += (movieItem.countries === element.countries) ? 2 : 0;
    score += (movieItem.genres.split(",").filter(item => element.genres.includes(item))).length * 3;
    score += (movieItem.tags.split(",").filter(item => element.tags.includes(item))).length * 4;
    element.score = score;
  });
  return movieDatabase.sort((x, y) => y.score - x.score).slice(1, 6);
}

const renderMovieItem = (element, review) => {
  const movieItem = element[0];
  document.getElementById("info").innerHTML = `
    <img src="${movieItem.image}">
    <p class="title">${movieItem.title}</p>
    <p>Rating: ${movieItem.rating}</p>
    <p>Year: ${movieItem.year}</p>
    <p>Directors: ${movieItem.directors}</p>
    <p>Casts: ${movieItem.casts.split(",").join(", ")}</p>
    <p>Duration: ${movieItem.duration}
    <p>Country: ${movieItem.countries}
    <p>Genres: ${movieItem.genres.split(",").join(", ")}`

  document.getElementById("summary").innerHTML = `
    <h2>Summary: </h2>
    <p>${movieItem.summary}</p>`

    review.forEach(element => {
    const newRow = document.createElement("tr");
    newRow.innerHTML = `
      <td>
        <img src=${element.authorProfile}>
        <p>${element.authorName}</p>
      </td>
      <td class="comment">${element.review}</td>`
    document.querySelector("table").appendChild(newRow);
  });

  calculateScoreAndRank(movieItem).forEach(item => {
    const newMovie = document.createElement("div");
    newMovie.innerHTML = `
    <img src=${item.image}>
    <p class="title">${item.title}</p>
    <p>${item.year}</p>`
    document.getElementById("recommended-movies").appendChild(newMovie);
  });
}

const addEvents = () => {
  document.addEventListener("click", event => {
    if (event.target.className === "all-list") {
      clearList("movies");
      renderMovie(movieList);
    }
    if (event.target.className === "genre-list") {
      let target = filterList(event.target.id);
      clearList("movies");
      renderMovie(target);
    }
    if (event.target.className === "page-number") {
      let page = event.target.innerText;
      let moviePage = getDataByPage(page);
      clearList("movies");
      renderMovie(moviePage);
    }
    if (event.target.id === "search-button") {
      const value = document.getElementById("search-area").value;
      window.open(`search-results.html?value=${value}`, "_self");
    }
    if (event.target.className === "title") {
      const title = event.target.innerText;
      window.open(`movie-details.html?value=${title}`, "_self");
    }
  });
}