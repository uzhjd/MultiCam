window.onload = function() {
  var name = prompt("이름을 입력해주세요!ㅇ!", "홍길동");
  var welcome = document.getElementById('welcome');

  var clock = document.getElementById('clock');
  welcome.innerHTML = name + "님 안녕하세요!ㅇ!";

  setInterval(function() {
    var now = new Date();
    clock.innerHTML = now.toLocaleString();
  }, 1000);
}