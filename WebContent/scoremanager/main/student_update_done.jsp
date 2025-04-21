<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">
  <c:param name="title">得点管理システム</c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">

    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">変更完了</h2>

      <div class="alert alert-success mx-4">
        学生情報の変更が完了しました。
      </div>

      <div class="text-end px-4">
        <a href="StudentList.action" class="btn btn-secondary">学生一覧に戻る</a>
      </div>
    </section>

  </c:param>
</c:import>
