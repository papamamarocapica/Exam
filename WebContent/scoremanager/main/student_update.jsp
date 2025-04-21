<%-- 学生変更 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">
  <c:param name="title">得点管理システム</c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">

    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">学生変更</h2>

      <div class="my-2 text-end px-4">
        <a href="StudentList.action">戻る</a>
      </div>

      <form action="StudentUpdateExecute.action" method="post" class="px-4">

        <input type="hidden" name="no" value="${student.no}" />

        <div class="mb-3">
          <label class="form-label">学生番号</label>
          <input type="text" class="form-control" value="${student.no}" disabled>
        </div>

        <div class="mb-3">
          <label class="form-label">氏名</label>
          <input type="text" name="name" class="form-control" value="${student.name}" maxlength="30" required>
        </div>

        <div class="mb-3">
          <label class="form-label">入学年度</label>
          <input type="number" name="entYear" class="form-control" value="${student.entYear}" required>
        </div>

        <div class="mb-3">
          <label class="form-label">クラス</label>
          <input type="text" name="classNum" class="form-control" value="${student.classNum}" required>
        </div>

        <div class="mb-3">
          <label class="form-label">在学中</label>
          <select name="isAttend" class="form-select">
            <option value="true" <c:if test="${student.attend}">selected</c:if>>在学中</option>
            <option value="false" <c:if test="${!student.attend}">selected</c:if>>卒業・退学</option>
          </select>
        </div>

        <div class="mb-3">
          <label class="form-label">学校コード</label>
          <input type="text" name="schoolCd" class="form-control" value="${student.school.cd}" required>
        </div>

        <div class="text-end">
          <input type="submit" class="btn btn-primary" value="変更">
        </div>

        <div class="mt-2 text-danger">${errorMessage}</div>

      </form>
    </section>

  </c:param>
</c:import>
