package com.example.mvc.controller.put

import com.example.mvc.model.http.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String{
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String{
        return "request-mapping - put method"
    }


    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {

        if(bindingResult.hasErrors()){
            // 500 error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field+" : "+message+"\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.ok("ok")



/*
        // 0. Response
        return UserResponse().apply {
            // 1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            //2. description
            this.description = "~~~~~~~~~"

        }.apply {
            //3. user mutable list
            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest) // 요청 들어온 거 추가

            // 밑에는 임의의 값 추가
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@gmail.com"
                this.address = "a address"
                this.phoneNumber = "1111111111"
            })
            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 100
                this.email = "ab@gmail.com"
                this.address = "a address"
                this.phoneNumber = "21111111111"
            })
            this.userRequest = userList
        }*/
    }
}

/*
어떤 response를 원하는지. json

{
    "result" : {
        "result_code" : "ok",
        "result_message" : "성공"
    },

    "description" : "~~~~~~",

    "user" : [
        {   "name" : "steve",
            "age" : 10,
            "email" : "aa",
            "phoneNumber" : ""
        },
           "name" : "steve",
            "age" : 10,
            "email" : "aa",
            "phoneNumber" : ""
        }
    ]
}

* */