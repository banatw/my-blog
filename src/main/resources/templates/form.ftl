<#include "fragments/header.ftl">
<div class="content-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">BASIC FORM</div>
					<#if error??>
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>Warning! </strong><a href="#" class="alert-link">${error}</a>
					</div>
					</#if>
					<div class="panel-body">
						<form role="form" method="post" action="/admin/post_simpan">
							<div class="form-group">
								<label>Title</label> <input class="form-control" type="text"
									name="postTitle"
									<#if postForm.postTitle??>  value="${postForm.postTitle}" </#if> />
								<!-- <p class="help-block">Help text here.</p> -->
							</div>

							<div class="form-group">
								<label>Sub Title</label> <input class="form-control" type="text"
									name="postSubTitle"
									<#if postForm.postSubTitle??>  value="${postForm.postSubTitle}" </#if> />
								<!-- <p class="help-block">Help text here.</p> -->
							</div>


							<div class="form-group">
							<label>Post Date</label>
								<div class='input-group date' id='datetimepicker1'>
									<input type='text' class="form-control" name="postDate" id="postdate"
									<#if postForm.postDate??>  value="${postForm.postDate}" </#if> />
										<span class="input-group-addon"> 
											<span class="glyphicon glyphicon-calendar" ></span>
										</span>
								</div>
							</div>


							<div class="form-group">
								<label>Category</label> <select class="form-control"
									name="idCategory">
								   <#list categories as category>
										<option value="${category.idCategory}" <#if postForm.idCategory??><#if postForm.idCategory==category.idCategory>selected</#if></#if>  >${category.categoryDescription}</option>
							       </#list>
								</select>
							</div>



							<div class="form-group">
								<label>Content</label>
								<textarea name="postContent" class="form-control" rows="3">
								<#if postForm.postContent??>${postForm.postContent}</#if>
								</textarea>
							</div>

							<!--<input type="hidden" name="_csrf" value="{{_csrf.token}}">-->
							<input type="hidden" name="idPost"
								<#if postForm.idPost??> value="${postForm.idPost}" </#if> >
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<button type="submit" class="btn btn-info">Simpan</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="../bootstrap-assets/js/jquery-2.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../bootstrap-assets/js/bootstrap.min.js"></script>
<!-- TINY MCE SCRIPTS  -->
<script src="../tinymce-assets/tinymce.min.js"></script>

<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script> -->

<script src="../bootstrap-assets/js/moment-with-locales.js"></script>
<script src="../bootstrap-assets/js/bootstrap-datetimepicker.js"></script>

<script src="../bootstrap-assets/js/bootbox.min.js"></script>

<script>
tinymce.init({
	selector : 'textarea',
	branding : false,
	menubar : false
});


    $('#datetimepicker1').datetimepicker({
    			format : 'DD-MM-YYYY HH:mm',
    			locale: 'id'
    });
</script>
</body>
</html>
