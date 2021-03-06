
<div class="page-header">
	<h1>Show Connectivity</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<dl class="dl-horizontal">
	
	<dt>Bluetooth</dt>
	<dd data-ng-bind="item.bluetooth"></dd>
	
	<dt>Cell</dt>
	<dd data-ng-bind="item.cell"></dd>
	
	<dt>Gps</dt>
	<dd data-ng-bind="item.gps"></dd>
	
	<dt>Infrared</dt>
	<dd data-ng-bind="item.infrared"></dd>
	
	<dt>Wifi</dt>
	<dd data-ng-bind="item.wifi"></dd>
	
</dl>
<div class="form-actions">
	<a class="btn" data-ng-href="#/edit/{{item.id}}"><i class="icon-edit"></i> Edit</a>
	<button type="button" class="btn btn-danger" data-ng-click="delete(item)"><i class="icon-trash"></i> Delete</button>
</div>
