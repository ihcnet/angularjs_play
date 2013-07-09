
<div class="page-header">
	<h1>Show Android</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<dl class="dl-horizontal">
	
	<dt>Os</dt>
	<dd data-ng-bind="item.os"></dd>
	
	<dt>Ui</dt>
	<dd data-ng-bind="item.ui"></dd>
	
</dl>
<div class="form-actions">
	<a class="btn" data-ng-href="#/edit/{{item.id}}"><i class="icon-edit"></i> Edit</a>
	<button type="button" class="btn btn-danger" data-ng-click="delete(item)"><i class="icon-trash"></i> Delete</button>
</div>
