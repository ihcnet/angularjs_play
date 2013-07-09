
<div class="page-header">
	<h1>Show Display</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<dl class="dl-horizontal">
	
	<dt>Screen Resolution</dt>
	<dd data-ng-bind="item.screenResolution"></dd>
	
	<dt>Screen Size</dt>
	<dd data-ng-bind="item.screenSize"></dd>
	
	<dt>Touch Screen</dt>
	<dd data-ng-bind="item.touchScreen"></dd>
	
</dl>
<div class="form-actions">
	<a class="btn" data-ng-href="#/edit/{{item.id}}"><i class="icon-edit"></i> Edit</a>
	<button type="button" class="btn btn-danger" data-ng-click="delete(item)"><i class="icon-trash"></i> Delete</button>
</div>
