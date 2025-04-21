<%-- 学生追加 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">

	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me=4">
			<h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">学生登録</h2>

			<div class="my-2 text-end px-4">
				<a href="StudentList.action">戻る</a>
			</div>

			<form action="StudentCreateExecute.action" method="post" class="px-4">

				<div class="mb-3">
					<label class="form-label"for="student-f1-select">入学年度</label>
					<select class="form-select" id="student-f1-select" name="f1">
							<option value="0">--------</option>
							<c:forEach var="year" items="${ent_year_set }">
								<option value="${year }">${year }</option>
							</c:forEach>
					</select>

				</div>

				<div class="mb-3">
					<label class="form-label" for="student-f2-select">学生番号</label>
						<input type="text" class="form-control" placeholder="学生番号を入力してください" name="f2" maxlength=10 required value="${no}">
				</div>

				<div class="mb-3">
					<label class="form-label" for="student-f3-select">氏名</label>
						<input type="text" class="form-control" placeholder="氏名を入力してください" name="f3" required value="${name}">
				</div>


			    <div class="mb-3">
						<label class="form-label" for="student-f4-select">クラス</label>
						<select class="form-select" id="student-f4-select" name="f4">
							<option value="0">--------</option>
							<c:forEach var="num" items="${class_num_set }">
								<option value="${num }">${num }</option>
							</c:forEach>
						</select>
					</div>


				<%-- <div class="mb-3">
					<label for="schoolCd" class="form-label">学校コード（cd）</label>
					<input type="text" id="schoolCd" name="schoolCd" class="form-control">
				</div>
				--%>
				<div class="mb-3 text-left">
					<button class="btn btn-secondary" id="filter-button">登録して終了</button>

				</div>

				<div class="mt-2 text-danger">${errorMessage}</div>

			</form>
		</section>
	</c:param>

</c:import>




