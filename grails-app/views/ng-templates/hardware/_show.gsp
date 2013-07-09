
<div class="page-header">
	<h1>Show Hardware</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<dl class="dl-horizontal">
	
	<dt>Accelerometer</dt>
	<dd data-ng-bind="item.accelerometer"></dd>
	
	<dt>Audio Jack</dt>
	<dd data-ng-bind="item.audioJack"></dd>
	
	<dt>Cpu</dt>
	<dd data-ng-bind="item.cpu"></dd>
	
	<dt>Fm Radio</dt>
	<dd data-ng-bind="item.fmRadio"></dd>
	
	<dt>Physical Keyboard</dt>
	<dd data-ng-bind="item.physicalKeyboard"></dd>
	
	<dt>Usb</dt>
	<dd data-ng-bind="item.usb"></dd>
	
</dl>
<div class="form-actions">
	<a class="btn" data-ng-href="#/edit/{{item.id}}"><i class="icon-edit"></i> Edit</a>
	<button type="button" class="btn btn-danger" data-ng-click="delete(item)"><i class="icon-trash"></i> Delete</button>
</div>
