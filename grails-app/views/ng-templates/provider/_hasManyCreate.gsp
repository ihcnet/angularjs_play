
<g:set var="ProviderSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>

<div class="control-group" data-ng-class="{error: errors.${ProviderSubPrefix}name}">
    <label class="control-label" for="${ProviderSubPrefix}name">Name</label>
    <div class="controls">
        <input type="text" id="name" name="name" data-ng-model="${ProviderSubPrefix}name">

        <span class="help-inline" data-ng-show="errors.${ProviderSubPrefix}name">{{errors.${ProviderSubPrefix}name}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />


