package com.example.homeweb.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.homeweb.model.UserList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * ユーザー情報のAPI取得
 *
 * @author user
 *
 */
@Tag(name = "ユーザー", description = "ユーザーに関するAPIです。")
public interface UserController {

	@Operation(tags = "ユーザー", summary = "ユーザー取得", description = "ユーザー情報を取得します。")
	@GetMapping(path = "user/{id}")
	public UserList getUser(@PathVariable String id);

	@GetMapping(path = "users")
	@Operation(tags = "ユーザー", summary = "ユーザーリストに追加", description = "ユーザー情報をリストに追加します。")
	public List<UserList> getUsers();

	@PostMapping(path = "user")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(tags = "ユーザー", summary = "ユーザー作成", description = "ユーザーを作成します。")
	public void createUser(final @Validated @RequestBody UserList user, final BindingResult bindingResult);

	@PutMapping(path = "user/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(tags = "ユーザー", summary = "ユーザー更新", description = "ユーザー情報を更新します。")
	public void updateUser(@PathVariable String id, @Validated @RequestBody UserList user,
			final BindingResult bindingResult);

	@DeleteMapping(path = "user/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(tags = "ユーザー", summary = "ユーザー削除", description = "ユーザー情報を削除します。")
	public void deleteUser(@PathVariable String id);
}
