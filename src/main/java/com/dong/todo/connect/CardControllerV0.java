package com.dong.todo.connect;

import com.dong.todo.dto.CardDtoRequest;
import com.dong.todo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/card/v0")
public class CardControllerV0 {
    // 일부러 멍청하고 이상하게 만든 코드임. v1 쓰셈..제발

    private final CardService cardService;

    @PostMapping
    public Object create(@RequestBody CardDtoRequest cardDtoRequest) {
        return cardService.addTodo(cardDtoRequest.toEntity());
    }

    @GetMapping("/{id}")
    public Object read(@PathVariable Long id) {
        return cardService.read(id);
    }

    @PutMapping("/{id}")
    public Object write(@PathVariable Long id, @RequestBody CardDtoRequest cardDtoRequest) {
        cardService.update(id, cardDtoRequest.toEntity());
        return null;
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Long id) {
        return cardService.delete(id);
    }


}
