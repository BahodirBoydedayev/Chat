app.controller('appCtrl', function ($scope) {

    var stompClient = null;
    stompClient = Stomp.over(new SockJS('/connect'));

    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/notification', function (response) {
            console.log(response);
            //showMessage(JSON.parse(response.body).text);
        });

        stompClient.subscribe("/user/queue", function (response) {
            alert(response.body);
        })
    }, function errorCallback(error) {
    });

    $scope.sendMessage = function () {
        //var message = document.getElementById('message').value;
        stompClient.send("/app/message", {}, JSON.stringify({'text': "hello"}));
    };

    //
    //function disconnect() {
    //    if (stompClient != null) {
    //        stompClient.disconnect();
    //    }
    //    setConnected(false);
    //    console.log("Disconnected");
    //}

    //
    //function showMessage(message) {
    //    var response = document.getElementById('response');
    //    var p = document.createElement('p');
    //    p.style.wordWrap = 'break-word';
    //    p.appendChild(document.createTextNode(message));
    //    response.appendChild(p);
    //}
    // xetsenad El
});
