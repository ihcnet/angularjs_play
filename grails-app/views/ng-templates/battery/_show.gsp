
<div class="page-header">
	<h1>Show Battery</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<dl class="dl-horizontal">
	
	<dt>Stand By Time</dt>
	<dd data-ng-bind="item.standByTime"></dd>
	
	<dt>Talk Time</dt>
	<dd data-ng-bind="item.talkTime"></dd>
	
	<dt>Type</dt>
	<dd data-ng-bind="item.type"></dd>
	
</dl>
<div class="form-actions">
	<a class="btn" data-ng-href="#/edit/{{item.id}}"><i class="icon-edit"></i> Edit</a>
	<button type="button" class="btn btn-danger" data-ng-click="delete(item)"><i class="icon-trash"></i> Delete</button>
</div>
