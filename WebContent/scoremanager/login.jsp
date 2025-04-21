<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>


	<c:param name="scripts">
	     <script>
            function togglePasswordVisibility() {
                const passwordInput = document.querySelector('input[name="password"]');
                const checkbox = document.getElementById('chk_d_ps');
                if (checkbox.checked) {
                    passwordInput.type = 'text';
                } else {
                    passwordInput.type = 'password';
                }
            }

            document.addEventListener('DOMContentLoaded', function() {
                const checkbox = document.getElementById('chk_d_ps');
                checkbox.addEventListener('change', togglePasswordVisibility);
            });
        </script>

	</c:param>


	<c:param name="content">
		<div class="border text-center">
			<h2 class="h3 bg-secondary bg-opacity-10 py-2 px-4">ログアウト</h2>
			<c:if test="${errors.get('error_login') != null }">
				<div class="mb-3">
					<ul>
						<li>${errors.get("error_login") }</li>
					</ul>
				</div>
			</c:if>
			<form method="post" action="LoginExecute.action">
				<div class="mx-3 mb-3 align-items-center">
					<input type="text" class="mb-3 form-control" placeholder="ID" name="id" required value="${id }">
					<input
						<c:choose>
							<c:when test="${not empty chk_d_ps }">
								type="text"
							</c:when>
							<c:otherwise>
								type="password"
							</c:otherwise>
						</c:choose>
					 class="mb-3 form-control" placeholder="パスワード" name="password" required value="${password }">
					<div class="form-check mb-3">
						<input type="checkbox" name="chk_d_ps" id="chk_d_ps">
						<label class="form-check-label" for="chk_d_ps">パスワードを表示</label>
					</div>
				</div>
				<div class="mb-3 text-center">
					<button class="btn btn-primary" name="login" value="ログイン">ログイン</button>
				</div>

			</form>
		</div>
	</c:param>
</c:import>