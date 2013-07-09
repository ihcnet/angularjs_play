
<div class="page-header">
	<h1>Show Phone</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<dl class="dl-horizontal">
	
	<dt>Name</dt>
	<dd data-ng-bind="item.name"></dd>
	
	<dt>Snippet</dt>
	<dd data-ng-bind="item.snippet"></dd>
	
	<dt>Age</dt>
	<dd data-ng-bind="item.age"></dd>
	
	<dt>Os</dt>
	<dd data-ng-bind="item.os"></dd>
	
	<dt>Battery</dt>
	<dd data-ng-bind="item.battery"></dd>
	
	<dt>Connectivity</dt>
	<dd data-ng-bind="item.connectivity"></dd>
	
	<dt>Description</dt>
	<dd data-ng-bind="item.description"></dd>
	
	<dt>Display</dt>
	<dd data-ng-bind="item.display"></dd>
	
	<dt>Hardware</dt>
	<dd data-ng-bind="item.hardware"></dd>
	
	<dt>Additional Feature</dt>
	<dd data-ng-bind="item.additionalFeature"></dd>
	
	<dt>Camera</dt>
	<dd data-ng-bind="item.camera"></dd>
	
	<dt>Images</dt>
	<dd data-ng-bind="item.images"></dd>
	
	<dt>Providers</dt>
	<dd data-ng-bind="item.providers"></dd>
	
</dl>
<div class="form-actions">
	<a class="btn" data-ng-href="#/edit/{{item.id}}"><i class="icon-edit"></i> Edit</a>
	<button type="button" class="btn btn-danger" data-ng-click="delete(item)"><i class="icon-trash"></i> Delete</button>
</div>
