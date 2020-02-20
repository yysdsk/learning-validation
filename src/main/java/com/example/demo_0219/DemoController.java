package com.example.demo_0219;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @PostMapping("/")
    public ResponseEntity<String> foo(@RequestBody @Validated Target target, BindingResult result) {

        String body = "----------結果----------\n";
        int httpStatusCode = 200;

        if (result.getFieldErrorCount() == 0) {
            body = body + "エラーは有りませんでした。\n"
                    + "foo: " + target.getFoo() + "\n"
                    + "bar: " + target.getBar() + "\n"
                    + "baz: " + target.getBaz() + "\n"
                    + "qux: " + target.getQux() + "\n";
        } else {
//            System.out.println("----------------------------------");
//        System.out.println(result.getAllErrors());
//        System.out.println("Model: " + result.getModel());
//        System.out.println(result.getPropertyEditorRegistry());
//        System.out.println(result.getSuppressedFields());
//            System.out.println(result.getFieldErrorCount());
//            System.out.println(result.getErrorCount());
//            System.out.println(result.getFieldError()); //どれか一個だけ
//        System.out.println(result.getFieldError().hashCode()); //エラーがないとヌルポが出る
//        System.out.println(result.getFieldError().isBindingFailure());
//            System.out.println(result.getFieldError("qux").getField()); //エラーがないとヌルポが出る
//        System.out.println(result.getFieldError().getRejectedValue());
//            System.out.println(result.getFieldErrors()); //一覧をListで
//            System.out.println(result.getFieldErrors().get(0).getField()); //一覧をListで
//            System.out.println(result.getFieldErrors().get(0).isBindingFailure());
//            System.out.println(result.getFieldErrors().get(0).getRejectedValue());
//        System.out.println("Target:" + result.getTarget());
//        System.out.println("GlobalErrors: " + result.getGlobalErrors());

            String fields = "---------エラー箇所---------\n";

            for (int i = 0; i < result.getFieldErrorCount(); i++) {
                fields = fields
                        + i + "番目の理由: " + result.getFieldErrors().get(i).getDefaultMessage() + "\n"
                        + i + "番目の中身 - " + result.getFieldErrors().get(i).getField() + ": " + result.getFieldErrors().get(i).getRejectedValue() + "\n";
            }

            body = body
                    + "「" + result.getObjectName() + "」オブジェクトで、\n"
                    + result.getErrorCount() + "件のエラーが有りました。\n"
                    + fields + "\n";
            httpStatusCode = 400;
        }

        return new ResponseEntity<>(body, HttpStatus.valueOf(httpStatusCode));
    }
}
