<#include "fragments/header.ftl">
<div class="row">
	<div class="col-sm-1 col-lg-1">
		<a href="/admin/post_add" class="btn btn-info" role="button"
			data-toggle="tooltip" title="Add"> <span
			class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		</a>
	</div>
	<div class="col-md-8 col-lg-8">
		<form method="get" action="/admin">
			<div class="input-group">
				<input type="text" name="query"
					<#if query??> value="${query}" </#if> class="form-control"
					placeholder="Search">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
<br>
<div>
	<div class="table-responsive">
		<div id="table-content">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Title</th>
						<th>Category</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<#list posts as post>
					<tr>
						<td>${post.postTitle}</td>
						<td>${post.categoryDescription}</td>
						<td>${post.postDate}</td>
						<td>
							<div class="row-fluid">
								<a href="/admin/post_edit?idPost=${post.idPost}"
									class="btn btn-info" data-toggle="tooltip" title="Edit"
									role="button"> <span class="glyphicon glyphicon-pencil"
									aria-hidden="true"></span>
								</a> <a href="/admin/post_delete?idPost=${post.idPost}"
									class="btn btn-info konfirmasi" role="button"
									data-toggle="tooltip" title="Delete"> <span
									class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</a>
							</div>

						</td>
					</tr>
					</#list>
				</tbody>
			</table>

		</div>
	</div>
	<div id="page-selection"></div>
</div>


<!-- CONTENT-WRAPPER SECTION END-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../bootstrap-assets/js/jquery-2.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../bootstrap-assets/js/bootstrap.min.js"></script>


<script src="../bootstrap-assets/js/bootbox.min.js"></script>
<script src="../blog-assets/js/jquery.bootpag.min.js"></script>

<script>
	$('#page-selection').bootpag({
            total: ${totalPages},
            maxVisible: 10,
            page: ${page},
            href: 'admin?page={{number}}&query=${query}'
    });


	$('.konfirmasi').on('click', function(event) {
		var link = $(this).attr("href");
		event.preventDefault();
		bootbox.confirm("Apakah anda yakin", function(result) {
			if (result) {
				window.location.href = link;
			}
		});

	});


</script>
</body>
</h
