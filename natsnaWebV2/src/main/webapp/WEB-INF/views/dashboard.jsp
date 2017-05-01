<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Natsna</title>


<%@include file="./common/header.jsp"%>



	<h2>Welcome to Natsa.</h2> 
	<h3>This version is ToyProject.ver.0.0.1</h3>
	
	<h4>-기본적인 CRUD 뼈대 만 구현</h4>
	<h4>-중복로그인  / 보안 처리 미구현 (스프링 시큐리티 적용 중))</h4>
	<h4>-회원가입 구현</h4>
	<h4>-TLS 적용 (사설인증: Keytool)</h4>
	<h4>자세한 사항은 <a href="https://gitlab.com/Ilwoong/natsna/boards" target="_blank">Gitlab board</a>를 참조</h4>
	
	<p>당신의 이름 : ${login.username}</p>
	<p>당신의 이메일 : ${login.email}</p>
	<p>당신의 등급 : ${login.role}</p>

<%@include file="./common/footer.jsp"%>
