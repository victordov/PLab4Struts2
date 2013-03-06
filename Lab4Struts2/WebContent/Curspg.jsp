<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="cursModelList!=null && cursModelList.size()>0">

	<div id="ajxTableData">
		<h1>Curs List</h1>
		<table class="ui-widget ui-widget-content">
			<caption>Curs</caption>
			<thead>
				<tr class="ui-widget-header">
					<th><s:property value="getText('global.cursId')" /></th>
					<th><s:property value="getText('global.denCurs')" /></th>
					<th><s:property value="getText('global.univId')" /></th>
					<th><s:property value="getText('global.profesorId')" /></th>
					<th><s:property value="getText('global.edit')" /></th>
					<th><s:property value="getText('global.delete')" /></th>
				</tr>
			</thead>
			<s:iterator value="cursModelList">
				<tr>
					<td><s:property value="cursId" /></td>
					<td><s:property value="numeCurs" /></td>
					<td><s:property value="universitateId" /></td>
					<td><s:property value="profesorId" /></td>
					<td>
							<a href="javascript:void(null)"
								onclick="editCurs(<s:property value="cursId" />)">Edit
							</a>
						</td>
					<td>
						<a href="javascript:void(null)" onclick="deleteCurs(<s:property value="cursId" />)" id="delCursLink<s:property value="cursId" />">
							<s:property value="getText('global.delete')" />
						</a>
					</td>
				</tr>
			</s:iterator>
		</table>

		<!-- Pagination Logic -->
		<div id="pager">
			<s:iterator value="pgArray" var="m">
				<s:if test="pgNr == #m+1">
				
				<a href="javascript:void(null)"
						onclick="$nxtPgCurs(<s:property value="#m+1" />)"><strong><s:property
							value="#m+1" /></strong></a>
				
				</s:if>
				<s:else>
					<a href="javascript:void(null)"
						onclick="$nxtPgCurs(<s:property value="#m+1" />)"><s:property
							value="#m+1" /></a>
				</s:else>
				</s:iterator>
		</div>
	</div>
</s:if>