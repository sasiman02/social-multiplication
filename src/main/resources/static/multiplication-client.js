function updateMultiplication() {
    $.ajax({
        url: "http://localhost:8080/multiplications/random"
    }).then(function (data) {
        $("#attempt-form").find("input[name='result-attempt']").val("");
        $("#attempt-form").find("input[name='user-alias']").val("");

        $('.multiplication-a').empty().append(data.factorA);
        $('.multiplication-b').empty().append(data.factorB);
    });
}

$(document).ready(function () {
    updateMultiplication();

    $("#attempt-form").submit(function (event) {
        event.preventDefault();

        let a = $('.multiplication-a').text();
        let b = $('.multiplication-b').text();
        let $form = $(this),
            attempt = $form.find("input[name='result-attempt']").val(),
            userAlias = $form.find("input[name='user-alias'").val();

        let data = {user: {alias: userAlias}, multiplication: {factorA: a, factorB: b}, resultAttempt: attempt};
    })

    $.ajax({
        url: '/results',
        type: 'POST',
        data: JSON.stringify(this.data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result) {
            if (result.correct) {
                $('.result-message').empty().append("정답입니다! 축하드려오!");
            } else {
                $('.result-message').empty().append("오답입니다! 그래도 포기하지 말아요!");
            }
        }
    });

    updateMultiplication();
})