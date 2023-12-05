// I miss Vanilla JS so much!

function fetchProtectedData() {
  console.log(localStorage.getItem("accessToken"))
  fetch("/user", {
    headers: {
      Authorization: "Bearer " + localStorage.getItem("accessToken"),
    },
  })
    .then((r) => r.json())
    .then((data) => {
      console.log(data);
    })
    .catch((_) => {
      console.log(
        "You're not ADMIN so you don't have the right to access this resource."
      );
    });
}

document.addEventListener("DOMContentLoaded", () => {
  const usernameEl = document.getElementById("username");
  const passwordEl = document.getElementById("password");
  const btnSubmit = document.getElementById("btnSubmit");

  btnSubmit.addEventListener("click", (e) => {
    fetch("/authenticate", {
      headers: {
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify({
        username: usernameEl.value,
        password: passwordEl.value,
      }),
    })
      .then((r) => r.json())
      .then((j) => {
        localStorage.setItem("accessToken", j.accessToken);
        console.log(
          "Log in successfully! Access token has been set to localStorage."
        );
        fetchProtectedData();
      })
      .catch((_) => {
        console.log("Incorrect username or password");
      });
  });
});
